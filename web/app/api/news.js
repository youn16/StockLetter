import axios from 'axios';
import { URL } from './URL';


export const getNewsByCode = async code => {
    
    const response = await axios.get(`${URL}/stock/${code}/news`);
    return response.data;
};
