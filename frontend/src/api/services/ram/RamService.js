import Api from "../../Api";

class RamService {

  static findAll() {
    return Api.get('/ram')
      .catch(err => {console.log(err); return [];})
  }

  static findByRamType(ram_type) {
    return Api.get(`/ram?type=${ram_type}`);
  }

  static getRamTypes() {
    return Api.get('/ram/types')
      .catch(err => {console.log(err); return []})
  }

  static create(ramObject) {
    return Api.post('/ram', JSON.stringify(ramObject))
  }

  static update(ramObject) {
    return Api.put('/ram', JSON.stringify(ramObject))
  }
}

export default RamService;
