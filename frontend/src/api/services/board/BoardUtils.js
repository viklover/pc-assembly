import RamService from "../ram/RamService";
import {generateFields, generateFieldsWithDefaultValues} from "../../../util/util";
import CpuService from "../cpu/CpuService";

class BoardUtils {

  static FIELDS = {
    'name': {
      label: 'название',
      type: 'text',
      defaultValue: 'My Board'
    },
    'cpu_architecture': {
      label: 'архитектура',
      type: 'select',
      options: null
    },
    'ram_type': {
      label: 'тип памяти',
      type: 'select',
      options: null
    },
    'ram_slots': {
      label: 'макс. количество плашек памяти',
      type: 'number',
      min: 1,
      defaultValue: 8
    }
  }

  static async init() {
    if (BoardUtils.FIELDS.cpu_architecture.options == null)
      BoardUtils.FIELDS.cpu_architecture.options = await CpuService.getArchitectureList();

    if (BoardUtils.FIELDS.ram_type.options == null)
      BoardUtils.FIELDS.ram_type.options = await RamService.getRamTypes();
  }

  static generateModelFields(handleChangeField) {
    return generateFields(BoardUtils.FIELDS, handleChangeField)
  }

  static generateFieldsWithDefaultValues(handleChangeField, defaultValues) {
    return generateFieldsWithDefaultValues(BoardUtils.FIELDS, handleChangeField, defaultValues)
  }
}

export default BoardUtils;