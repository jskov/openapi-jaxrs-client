package dk.mada.jaxrs.generator;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.tmpl.dto.CtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.CtxProperty;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxProperty;
import dk.mada.jaxrs.model.ContainerArray;
import dk.mada.jaxrs.model.ContainerMap;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Property;

public class DtoGenerator {
	private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

	private final GeneratorOpts opts;
	private final Templates templates;
	private final Model model;


	public DtoGenerator(GeneratorOpts opts, Templates templates, Model model) {
		this.opts = opts;
		this.templates = templates;
		this.model = model;
	}
	
	public void generateDtoClasses(Path dtoDir) throws IOException {
		Files.createDirectories(dtoDir);
		model.types().get()
			.forEach(type -> {
				String name = type.name();
				logger.info(" generate type {}", name);

				Path dtoFile = dtoDir.resolve(dtoOutputName(type));
				
				CtxDto ctx = toCtx(type);
				
				templates.writeDto(ctx, dtoFile);
			});
	}
	
	private String dtoOutputName(Dto type) {
		return type.name() + ".java";
	}
	
	private CtxDto toCtx(Dto type) {
		Info info = model.info();
		
		List<CtxProperty> vars = type.properties().stream()
			.map(this::toCtxProperty)
			.collect(toList());
		
		return ImmutableCtxDto.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				
				.imports(type.imports())

				.packageName(opts.dtoPackage())
				.classname(type.name())
				.classVarName("other")
				
				.vars(vars)
				
				.build();
	}

	private CtxProperty toCtxProperty(Property p) {
		String name = p.name();
		String nameCamelized = p.nameCamelized();
		
		String defaultValue = null;
		boolean isArray = false;
		boolean isMap = false;
		String innerType = null;
		if (p.type() instanceof ContainerArray ca) {
			isArray = true;
			innerType = ca.innerType().typeName();
			defaultValue = "new ArrayList<>()";
		}
		if (p.type() instanceof ContainerMap cm) {
			isMap = true;
			innerType = cm.innerType().typeName();
			defaultValue = "new HashMap<>()";
		}

		return ImmutableCtxProperty.builder()
				.baseName(name)
				.datatypeWithEnum(p.type().typeName())
				.name(name)
				.nameInCamelCase(nameCamelized)
				.getter("get" + nameCamelized)
				.setter("set" + nameCamelized)
				.description(p.description())
				.isArray(isArray)
				.isMap(isMap)
				.innerDatatypeWithEnum(innerType)
				.defaultValue(defaultValue)
				.build();
	}
}
