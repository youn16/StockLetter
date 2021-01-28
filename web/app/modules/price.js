import * as priceAPI from '../api/price'; // api/price 안의 함수 모두 불러오기

/* 액션 타입 */

// 여러개 조회하기
const GET_PRICE = 'GET_PRICE'; // 요청 시작
const GET_PRICE_SUCCESS = 'GET_PRICE_SUCCESS'; // 요청 성공
const GET_PRICE_ERROR = 'GET_PRICE_ERROR'; // 요청 실패

export const getPriceByCode = code => async dispatch => {
  dispatch({ type: GET_PRICE }); // 요청이 시작됨
  try {
    const price = await priceAPI.getPriceByCode(code); // API 호출
    dispatch({ type: GET_PRICE_SUCCESS, price }); // 성공
  } catch (e) {
    dispatch({ type: GET_PRICE_ERROR, error: e }); // 실패
  }
};

const initialState = {
  price: {
    loading: false,
    data: [],
    error: [],
  }
};

export default function price(state = initialState, action) {
  switch (action.type) {
    case GET_PRICE:
      return {
        ...state,
        price: {
          loading: true,
          data: [],
          error: null
        }
      };
    case GET_PRICE_SUCCESS:
      return {
        ...state,
        price: {
          loading: false,
          data: action.price,
          error: null
        }
      };
    case GET_PRICE_ERROR:
      return {
        ...state,
        price: {
          loading: false,
          data: [],
          error: action.error
        }
      };
    default:
      return state;
  }
}