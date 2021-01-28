import * as newsAPI from '../api/news'; // api/news 안의 함수 모두 불러오기

/* 액션 타입 */

// 여러개 조회하기
const GET_NEWS = 'GET_NEWS'; // 요청 시작
const GET_NEWS_SUCCESS = 'GET_NEWS_SUCCESS'; // 요청 성공
const GET_NEWS_ERROR = 'GET_NEWS_ERROR'; // 요청 실패

export const getNewsByCode = code => async dispatch => {
  dispatch({ type: GET_NEWS }); // 요청이 시작됨
  try {
    const news = await newsAPI.getNewsByCode(code); // API 호출
    dispatch({ type: GET_NEWS_SUCCESS, news }); // 성공
  } catch (e) {
    dispatch({ type: GET_NEWS_ERROR, error: e }); // 실패
  }
};

const initialState = {
  news: {
    loading: false,
    data: [],
    error: null,
  }
};

export default function news(state = initialState, action) {
  switch (action.type) {
    case GET_NEWS:
      return {
        ...state,
        news: {
          loading: true,
          data: [],
          error: null
        }
      };
    case GET_NEWS_SUCCESS:
      return {
        ...state,
        news: {
          loading: false,
          data: action.news,
          error: null
        }
      };
    case GET_NEWS_ERROR:
      return {
        ...state,
        news: {
          loading: false,
          data: [],
          error: action.error
        }
      };
    default:
      return state;
  }
}