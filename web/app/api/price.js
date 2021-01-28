import axios from 'axios';
import { URL } from './URL';


export const getPriceByCode = async code => {
    
    const response = await axios.get(`${URL}/stock/${code}/finPrice`);
    return response.data;
};
