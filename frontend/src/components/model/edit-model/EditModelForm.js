
import { useEffect, useState } from "react";
import { capitalize } from "../../../util/util";

import Form from "../../form/Form";

const EditModelForm = (props) => {

  const [fields, setFields] = useState([])
  const [values, setValues] = useState({fields: {}})

  const [errorMessage, setErrorMessage] = useState("")

  const handleFieldChange = (field, value) => {
    let fields = values.fields
    fields[field] = value
    setValues({fields: fields})
  };

  useEffect(() => {
    props.utils.init().then(async(res) => {
      if (props.selectedModel !== null && props.selectedModel.fields !== null) {
        await setFields([])
        setFields(props.utils.generateFieldsWithDefaultValues(handleFieldChange, props.selectedModel))
        handleFieldChange('id', props.selectedModel.fields.id)
      }
    })
  }, [props.selectedModel])

  return (
    <>
      <Form
        title={`Редактирование ${capitalize(props.modelName)}`}
        active={props.active}
        submit={"Обновить"}
        submitCallback={async(e) => {
          e.preventDefault()
          props.service.update(values.fields)
            .catch(error => setErrorMessage(error))
            .then(() => {
              props.cancelCallback();
              props.onSubmit();
            })
        }}
        cancelCallback={props.cancelCallback}
      >
        {fields.map(field => field)}
        <p>{errorMessage}</p>
      </Form>
    </>
  )
}

export default EditModelForm;