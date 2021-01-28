import * as financeAPI from '../api/finance'; // api/finance 안의 함수 모두 불러오기

/* 액션 타입 */

// 여러개 조회하기
const GET_FINANCE = 'GET_FINANCE'; // 요청 시작
const GET_FINANCE_SUCCESS = 'GET_FINANCE_SUCCESS'; // 요청 성공
const GET_FINANCE_ERROR = 'GET_FINANCE_ERROR'; // 요청 실패

export const getFinanceByCode = code => async dispatch => {
  dispatch({ type: GET_FINANCE }); // 요청이 시작됨
  try {
    const finance = await financeAPI.getFinanceByCode(code); // API 호출
    dispatch({ type: GET_FINANCE_SUCCESS, finance }); // 성공
    console.log(finance)
  } catch (e) {
    dispatch({ type: GET_FINANCE_ERROR, error: e }); // 실패
  }
};

const initialState = {
  finance: {
    loading: false,
    data: [],
    error: [],
  }
};

export default function finance(state = initialState, action) {
  switch (action.type) {
    case GET_FINANCE:
      return {
        ...state,
        finance: {
          loading: true,
          data: [],
          error: null
        }
      };
    case GET_FINANCE_SUCCESS:
      return {
        ...state,
        finance: {
          loading: false,
          data: action.finance,
          error: null
        }
      };
    case GET_FINANCE_ERROR:
      return {
        ...state,
        finance: {
          loading: false,
          data: [],
          error: action.error
        }
      };
    default:
      return state;
  }
}