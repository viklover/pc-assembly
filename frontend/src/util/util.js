import NumberField from "../components/form/fields/NumberField";
import SelectField from "../components/form/fields/SelectField";
import TextField from "../components/form/fields/TextField";
import RamCombinationField from "../components/form/fields/RamCombinationField";

export const capitalize = (string) => {
  return string.charAt(0).toUpperCase() + string.slice(1);
}

export const findValueByKeyInObject = (object, fieldName) => {
  if (Object.keys(object).includes(fieldName)) {
    return object[fieldName]
  }
  return fieldName;
}

export const generateField = (field, props, callback) => {
  switch (props.type) {
    case 'number':
      return <NumberField
        name={field}
        label={props.label}
        onChange={callback}
        value={props.defaultValue}
        min={props.min}/>
    case 'select':
      return <SelectField
        name={field}
        label={props.label}
        onChange={callback}
        value={props.defaultValue}
        options={props.options}/>
    case 'ram_combination':
      return <RamCombinationField
        name={field}
        label={props.label}
        onChange={callback}
        value={props.defaultValue}
        combinations={props.combinations}/>
    default:
      return <TextField
        name={field}
        label={props.label}
        onChange={callback}
        value={props.defaultValue}/>
  }
}

export const generateFields = (fields, callback) => {
  return Object.keys(fields).map((fieldName) => generateField(fieldName, fields[fieldName], callback));
}

export const generateFieldsWithDefaultValues = (fields, callback, defaultValues) => {
  return Object.keys(fields).map(
    (fieldName) => {
      Object.entries(defaultValues.fields).map(([key, value]) => {
        if (key !== 'id')
          fields[key].defaultValue = value;
      })
      return generateField(fieldName, fields[fieldName], callback)
    }
  );
}
