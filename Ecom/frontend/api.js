import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json',
  },
});

export const registerUser = (userData) => API.post('/auth/signup', userData);

export const loginUser = (credentials) => API.post('/auth/login', credentials);

export const getAllProducts = () => API.get('/products');

export const addProduct = (product) => API.post('/products', product);

export default API;
