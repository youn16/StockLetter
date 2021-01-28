import '@babel/polyfill';
import React from 'react';
import { render } from 'react-dom';
import { createStore, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import App from './components/App';
import rootReducer from './modules';
import ReduxThunk from 'redux-thunk';

const store = createStore(
    rootReducer,
    applyMiddleware(ReduxThunk)
);

render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.querySelector('#root')
);