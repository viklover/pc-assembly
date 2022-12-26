import {useEffect, useState} from "react";
import {capitalize} from "../../../util/util";

const RamCombinationField = (props) => {

  const [value, setValue] = useState(props.value)

  useEffect(() => {
    props.onChange(props.name, value)
  }, [props, value])

  return (
    <>
      <div className={"form__field form__field-boxed"}>
        <label for={props.name} className={"form__field-name"}>{capitalize(props.label)}</label>
        <button></button>
        <input
          name={props.name}
          type={"number"}
          min={props.min}
          max={props.max}
          defaultValue={props.value}
          onInput={(e) => setValue(e.target.value)}
        />
      </div>
    </>
  )
}

export default RamCombinationField;
