import axios from 'axios'

export const http = axios.create({ baseURL: 'https://api-recantogeekv2.herokuapp.com/api/' })