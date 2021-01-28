import { combineReducers } from 'redux';
import subscribes from './subscribes';
import price from './price';
import finance from './finance'

const rootReducer = combineReducers(
    { subscribes, price, finance }
);

export default rootReducer;