Fields with Uppercase first letter in JBoss EAP74.

Generator must handle something like this:

        Omkostninger:
          allOf:
          - $ref: '#/components/schemas/Omkostninger'
          - $ref: '#/components/schemas/Omkostninger'

as if it was just:

        Omkostninger:
          $ref: '#/components/schemas/Omkostninger'
