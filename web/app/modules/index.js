import { combineReducers } from 'redux';
import subscribes from './subscribes';
import price from './price';
import finance from './finance'
import news from './news'

const rootReducer = combineReducers(
    { subscribes, price, finance, news }
);

export default rootReducer;