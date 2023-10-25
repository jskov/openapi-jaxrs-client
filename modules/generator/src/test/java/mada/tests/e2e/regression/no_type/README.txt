Manually created openapi.yaml from bpm motor

DTO has properties without type declaration:

    AendringElement:
      required:
      - aendring
      type: object
      properties:
        aendring:
          description: Ændring som beskrevet i KRO API
          type: string
        oprindelig:
          description: Oprindelig værdi
        ny:
          description: Ønsket værdi
