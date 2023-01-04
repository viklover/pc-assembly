import CpuService from "./CpuService";
import RamService from "../ram/RamService";
import {generateFields, generateFieldsWithDefaultValues} from "../../../util/util";

class CpuUtils {

  static FIELDS = {
    'name': {
      label: 'название',
      type: 'text',
      defaultValue: 'My Cpu'
    },
    'architecture': {
      label: 'архитектура',
      type: 'select',
      options: null
    },
    'speed': {
      label: 'скорость',
      type: 'number',
      min: 1,
      defaultValue: 3200
    },
    'ram_type': {
      label: 'тип памяти',
      type: 'select',
      options: null
    },
    'max_ram_capacity': {
      label: 'макс. объём памяти',
      type: 'number',
      min: 1,
      defaultValue: 16384
    }
  }

  static async init() {
    if (CpuUtils.FIELDS.architecture.options == null)
      CpuUtils.FIELDS.architecture.options = await CpuService.getArchitectureList();

    if (CpuUtils.FIELDS.ram_type.options == null)
      CpuUtils.FIELDS.ram_type.options = await RamService.getRamTypes();
  }

  static generateModelFields(handleChangeField) {
    return generateFields(CpuUtils.FIELDS, handleChangeField)
  }

  static generateFieldsWithDefaultValues(handleChangeField, defaultValues) {
    return generateFieldsWithDefaultValues(CpuUtils.FIELDS, handleChangeField, defaultValues)
  }
}

export default CpuUtils;