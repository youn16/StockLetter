import axios from 'axios';
import { URL } from './URL';


export const getSubscribes = async () => {
    
    const response = await axios.get(`${URL}/user/subscription`);
    return response.data;
};
