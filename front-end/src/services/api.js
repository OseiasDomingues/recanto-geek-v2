import { http } from './configApi'

export default {
    findAll: () => {
        return http.get('products')
    }
}