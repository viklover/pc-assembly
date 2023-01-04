import { useEffect, useState } from "react";
import { capitalize } from "../../../util/util";

const SelectField = (props) => {

  const [value, setValue] = useState(props.value !== undefined ? props.value : props.options[0])

  useEffect(() => {
    props.onChange(props.name, value)
  }, [props, value])

  return (
    <>
      <div className={"form__field"}>
        <label htmlFor={props.name} className={"form__field-name"}>{capitalize(props.label)}</label>
        <select
          name={props.name}
          defaultValue={props.value}
          onInput={(e) => setValue(e.target.value)}
        >
          {props.options.map(option => (
            <option value={option}>{option}</option>
          ))}
        </select>
      </div>
    </>
  )
}

export default SelectField;
