import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
//Custom
import { 
    Container,
    Row,
    CardColumns,
    Col
} from './../../../components';
import { HeaderMain } from "../../components/HeaderMain";
import { ReportCard } from "../../components/Report/ReportCard";
import { Paginations } from "../../components/Paginations";
import { getNewsByCode } from '../../../modules/news';

const ReportGrid = ({match}) => {
    const { code } = match.params;
    console.log(code)

    const { data, loading, error } = useSelector(state => state.news.news);
    const dispatch = useDispatch();

    // 컴포넌트 마운트 후 포스트 목록 요청
    useEffect(() => {
        dispatch(getNewsByCode(code));
    }, [dispatch,code]);
    if (loading) return <div>로딩중...</div>;
    if (error) return <div>에러 발생</div>;
    if (!data) return null;

    console.log(data);
    let id=1;
    return (
        <Container>
            <HeaderMain 
                title="News"
                className="mb-5 mt-4"
            />
            { /* START Content */}
            <Row>
                <Col lg={ 12 }>
                    <CardColumns>
                        {data.map( sub => (
                            <ReportCard 
                                data={sub} id={id+=1} 
                            />
                        ))}
                    </CardColumns>
                    {/* <div className="d-flex justify-content-center">
                        <Paginations />
                    </div> */}
                </Col>
            </Row>
            { /* END Content */}
        </Container>
    );
};

export default ReportGrid;