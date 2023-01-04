import RamService from "./RamService";

import { generateFields, generateFieldsWithDefaultValues } from "../../../util/util";

class RamUtils {

  static FIELDS = {
    'name': {
      label: 'название',
      type: 'text',
      defaultValue: 'My Ram'
    },
    'type': {
      label: 'тип памяти',
      type: 'select',
      options: null
    },
    'speed': {
      label: 'скорость',
      type: 'number',
      min: 1,
      defaultValue: 3200
    },
    'capacity': {
      label: 'объём',
      type: 'number',
      defaultValue: 8192
    }
  }

  static async init() {
    if (RamUtils.FIELDS.type.options == null)
      RamUtils.FIELDS.type.options = await RamService.getRamTypes();
  }

  static generateModelFields(handleChangeField) {
    return generateFields(RamUtils.FIELDS, handleChangeField)
  }

  static generateFieldsWithDefaultValues(handleChangeField, defaultValues) {
    return generateFieldsWithDefaultValues(RamUtils.FIELDS, handleChangeField, defaultValues)
  }
}

export default RamUtils