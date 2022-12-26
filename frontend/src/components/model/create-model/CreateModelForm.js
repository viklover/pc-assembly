
import { useEffect, useState } from "react";
import { capitalize } from "../../../util/util.js";

import Form from "../../form/Form.js";

const CreateModelForm = (props) => {

  const [fields, setFields] = useState([])
  const [values, setValues] = useState({fields: {}})

  const [errorMessage, setErrorMessage] = useState("")

  const handleFieldChange = (field, value) => {
    let fields = values.fields
    fields[field] = value
    setValues({fields: fields})
  };

  useEffect(() => {
    props.utils.init().then((res) => {
      setFields(props.utils.generateModelFields(handleFieldChange))
    })
  }, [])

  return (
    <>
      <Form
        title={capitalize(props.modelName)}
        active={props.active}
        submit={"Создать"}
        submitCallback={(e) => {
          e.preventDefault();
          props.service.create(values.fields)
            .catch(error => setErrorMessage(error))
            .then(res => {
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

export default CreateModelForm;
