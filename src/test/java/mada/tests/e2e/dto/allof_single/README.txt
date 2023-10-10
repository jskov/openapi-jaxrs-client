Quarkus 3+ generates new output when fields are annotated with @Schema such as:

# Quarkus 3
    DtoE:
      required:
      - member-in-E
      type: object
      properties:
        member-in-E:
          description: enum in E
          type: string
          allOf:
          - $ref: '#/components/schemas/EnumDescription'

# Quarkus 2
    DtoE:
      required:
      - member-in-E
      type: object
      properties:
        member-in-E:
          allOf:
          - $ref: '#/components/schemas/EnumDescription'
          - description: enum in E


Looks the same in editor.swagger.io.
