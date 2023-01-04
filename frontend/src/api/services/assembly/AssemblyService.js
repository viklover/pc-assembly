
import Api from "../../Api";

class AssemblyService {

  static findAll() {
    return Api.get('/assembly')
      .catch(err => {console.log(err); return []})
  }

  static create(body) {
    return Api.post('/assembly', JSON.stringify(body))
  }

  static update(body) {
    return Api.put('/assembly', JSON.stringify(body))
  }

  static delete(id) {
    return Api.delete(`/assembly?id=${id}`)
      .catch(err => {return []})
  }
}

export default AssemblyService;
