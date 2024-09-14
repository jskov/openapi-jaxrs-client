Manually added required to body get, as seen in EAP6 enunciate output

  /api/validation/body:
    put:
      tags:
      - Api Bean Validation
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Simple'
        required: true
