import Api from "../../Api";

class CpuService {

  static findAll() {
    return Api.get('/cpu')
      .catch(err => {console.log(err); return [];})
  }

  static getArchitectureList() {
    return Api.get('/cpu/architecture')
      .catch(err => {console.log(err); return [];})
  }

  static create(cpuObject) {
    return Api.post('/cpu', JSON.stringify(cpuObject))
  }

  static update(cpuObject) {
    return Api.put('/cpu', JSON.stringify(cpuObject))
  }
}

export default CpuService;
