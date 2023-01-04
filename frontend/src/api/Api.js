
class Api {

  static BASE_URL = process.env.REACT_APP_API_URL

  static request(method, endPoint, body) {
    return fetch(Api.BASE_URL + endPoint, {
      headers: {'Content-Type': 'application/json'},
      method: method,
      body: body
    }).then((data) => data.json())
  }

  static get(endPoint, body) {
    return Api.request('GET', endPoint, body)
  }

  static post(endPoint, body) {
    return Api.request('POST', endPoint, body)
  }

  static put(endPoint, body) {
    return Api.request('PUT', endPoint, body)
  }

  static delete(endPoint, body) {
    return Api.request('DELETE', endPoint, body)
  }
}

export default Api;