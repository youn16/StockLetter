import axios from 'axios';
import { URL } from './URL';


export const getFinanceByCode = async code => {
    
    const response = await axios.get(`${URL}/${code}/finPrice`);
    return response.data;
};
