import { useEffect, useState } from "react";
import {capitalize} from "../../../util/util";

const TextField = (props) => {

  const [value, setValue] = useState(props.value)

  useEffect(() => {
    props.onChange(props.name, value)
  }, [props, value])

  return (
    <>
      <div className={"form__field"}>
        <label for={props.name} className={"form__field-name"}>{capitalize(props.label)}</label>
        <input
          name={props.name}
          type={"text"}
          defaultValue={props.value}
          onInput={(e) => setValue(e.target.value)}
        />
      </div>
    </>
  )
}

export default TextField;
