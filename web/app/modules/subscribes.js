import * as subscribesAPI from '../api/subscribes'; // api/subscribes 안의 함수 모두 불러오기

/* 액션 타입 */

// 여러개 조회하기
const GET_SUBSCRIBES = 'GET_SUBSCRIBES'; // 요청 시작
const GET_SUBSCRIBES_SUCCESS = 'GET_SUBSCRIBES_SUCCESS'; // 요청 성공
const GET_SUBSCRIBES_ERROR = 'GET_SUBSCRIBES_ERROR'; // 요청 실패

export const getSubscribes = () => async dispatch => {
  dispatch({ type: GET_SUBSCRIBES }); // 요청이 시작됨
  try {
    const subscribes = await subscribesAPI.getSubscribes(); // API 호출
    dispatch({ type: GET_SUBSCRIBES_SUCCESS, subscribes }); // 성공
  } catch (e) {
    dispatch({ type: GET_SUBSCRIBES_ERROR, error: e }); // 실패
  }
};

const initialState = {
  subscribes: {
    loading: false,
    data: [],
    error: [],
  }
};

export default function subscribes(state = initialState, action) {
  switch (action.type) {
    case GET_SUBSCRIBES:
      return {
        ...state,
        subscribes: {
          loading: true,
          data: null,
          error: null
        }
      };
    case GET_SUBSCRIBES_SUCCESS:
      return {
        ...state,
        subscribes: {
          loading: false,
          data: action.subscribes,
          error: null
        }
      };
    case GET_SUBSCRIBES_ERROR:
      return {
        ...state,
        subscribes: {
          loading: false,
          data: null,
          error: action.error
        }
      };
    default:
      return state;
  }
}