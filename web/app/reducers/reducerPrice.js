/* 액션 타입 만들기 */
// Ducks 패턴을 따를땐 액션의 이름에 접두사를 넣어주세요.
// 이렇게 하면 다른 모듈과 액션 이름이 중복되는 것을 방지 할 수 있습니다.
const LOADING = 'news/LOADING';
const SUCCESS = 'news/SUCCESS';
const ERROR = 'news/ERROR';
const FETCH_DATA = 'news/FETCH_DATA';

/* 액션 생성함수 만들기 */
/*
export const setDiff = diff => ({ type: LOADING });
export const increase = () => ({ type: SUCCESS });
export const decrease = () => ({ type: ERROR });
*/
export const fetchData = (data) => {
    return {
        type: FETCH_DATA,
        data
    }
}
  
export const fetchTrending = () => {
    return (dispatch) => {
        return axios.get('https://jsonplaceholder.typicode.com/users')
            .then(response => {
                dispatch(fetchData(response.data))
            })
            .catch(error => {
                throw(error);
            });
    }
}


/* 초기 상태 선언 */
const initialState = {
  number: 0,
  diff: 1
};

/* 리듀서 선언 */
// 리듀서는 export default 로 내보내주세요.
export default function reducerPrice(state = initialState, action) {
  switch (action.type) {
    case FETCH_DATA:
        return action.data;
    case LOADING:
        return {
            loading: true,
            data: null,
            error: null
        };
    case SUCCESS:
        return {
            loading: false,
            data: action.data,
            error: null
        };
    case ERROR:
        return {
            loading: false,
            data: null,
            error: action.error
        };
    default:
      return state;
  }
}