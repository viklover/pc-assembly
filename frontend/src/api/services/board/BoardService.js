import Api from "../../Api";

class BoardService {

  static findAll() {
    return Api.get('/boards')
      .catch(err => {console.log(err); return [];})
  }

  static findByCpuArchitectureAndRamType(architecture, ram_type) {
    return Api.get(`/boards?cpu_architecture=${architecture}&ram_type=${ram_type}`)
  }

  static create(ramObject) {
    return Api.post('/boards', JSON.stringify(ramObject))
  }

  static update(ramObject) {
    return Api.put('/boards', JSON.stringify(ramObject))
  }
}

export default BoardService;