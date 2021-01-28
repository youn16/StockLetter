import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import {
    Container,
    Row,
    Card,
    CardBody,
    Table,
    Badge,
    CardTitle,
    CardDeck,
    Nav,
    Button,
    NavLink,
    NavItem,
    Col
} from './../../../components';
import { setupPage } from './../../../components/Layout/setupPage';

import { HeaderMain } from "../../components/HeaderMain";

import {
    SimpleLineChart
} from "../../components/Stock/SimpleLineChart"

import {
    TrTableStock
} from "../../components/Stock/TrTableStock"

import {
    TrTableFavStock
} from "../../components/Stock/TrTableFavStock"
import { PositiveAndNegativeBarChart } from '../../Graphs/ReCharts/components/PositiveAndNegativeBarChart';
import { getSubscribes } from '../../../modules/subscribes';
import { HeaderDemo } from '../../components/HeaderDemo';

const name = [
    "시장종류",
    "현재가",
    "전날 종가",
    "증감"
];
const Stock = () => {
    const { data, loading, error } = useSelector(state => state.subscribes.subscribes);
    const dispatch = useDispatch();

    // 컴포넌트 마운트 후 포스트 목록 요청
    useEffect(() => {
        dispatch(getSubscribes());
    }, [dispatch]);

    if (loading) return <div>로딩중...</div>;
    if (error) return <div>에러 발생</div>;
    if (!data) return null;

    let copy = data.slice(0, 5); // [3, 4, 5]
    return (
        <Container>
            <Row className="mb-2">
                <Col lg={12}>
                    <HeaderMain
                        title="오늘의 구독 정보"
                        className="mb-4 mb-lg-4"
                    />
                </Col>
            </Row>
            <Row>
                <Col lg={12}>
                    <HeaderDemo
                        no={1}
                        title="내 구독 기업 한눈에 보기"
                        subTitle={(
                            <React.Fragment>
                                <strong>보아요</strong>
                            </React.Fragment>
                        )}
                    />
                </Col>
            </Row>
            <Row>
                <Col lg={12}>
                    <Table responsive size="sm" className="mb-4 text-nowrap">
                        <thead>
                            <tr>
                                <td className="bt-0">
                                    <h4 className="mb-1">
                                        지금 주식!?
                                </h4>
                                </td>
                                {
                                    copy.map((sub, index) => (

                                        <td className="bt-0">
                                            <h4 className="mb-1">
                                                {sub.stockName}
                                            </h4>
                                            <span className="text-success">
                                                {
                                                    sub.difference > 0
                                                        ? (<i className="fa fa-caret-up mr-1"></i>)
                                                        : (<i className="fa fa-caret-down mr-1"></i>)
                                                }
                                                {sub.difference}
                                            </span>
                                        </td>
                                    ))}
                            </tr>
                        </thead>
                        <tbody>
                            <td className="align-middle">
                                {
                                    name.map((sub, index) => (

                                        <tr className="align-middle">
                                            { sub}
                                        </tr>
                                    ))}
                            </td>
                            <TrTableFavStock data={copy} />
                        </tbody>
                    </Table>
                </Col>
            </Row>
            <Row>
                <Col lg={12}>
                    <HeaderDemo
                        no={2}
                        title="시장 정보"
                        subTitle={(
                            <React.Fragment>
                                <strong>어려운 내용도 </strong>
                            </React.Fragment>
                        )}
                    />
                </Col>
            </Row>
            <Row>
                <Col lg={6}>
                    <Card className="mb-3">
                        <CardBody>
                            <span className="d-flex mb-3">
                                <CardTitle>
                                    <h6>증권 정보</h6>
                                </CardTitle>
                                <Badge pill className="ml-auto align-self-start"> Daily </Badge>
                            </span>
                            <div className="text-center">
                                <SimpleLineChart />
                            </div>
                        </CardBody>
                    </Card>
                </Col>

                <Col lg={6}>
                    <Card className="mb-3">
                        <CardBody>
                            <div className="d-flex">
                                <div>
                                    <h6 className="card-title mb-1">투자자 동향</h6>
                                    <p>2021-01-28</p>
                                </div>
                                <span className="ml-auto">
                                </span>
                            </div>
                            <PositiveAndNegativeBarChart />
                        </CardBody>
                    </Card>
                </Col>
                
            <Col lg={ 6 }>
                <Card className="mb-3">
                    <CardBody className="pb-1">
                        <CardTitle className="mb-0">
                            <h6>
                                Cheap Stock 
                            </h6>
                        </CardTitle>
                    </CardBody>
                    <Table responsive striped className="mb-0">
                        <thead>
                            <tr>
                                <th className="bt-0"></th>
                                <th className="bt-0 text-right">Price</th>
                                <th className="bt-0 text-right">Score</th>
                                <th className="bt-0 text-right">Q</th>
                                <th className="bt-0 text-right">V</th>
                                <th className="bt-0 text-right">G</th>
                            </tr>
                        </thead>
                        <tbody>
                            <TrTableStock />
                        </tbody>
                    </Table>
                </Card>
            </Col>
            <Col lg={ 6 }>
                <Card className="mb-3">
                    <CardBody className="pb-1">
                        <CardTitle className="mb-0">
                            <h6>
                                Expensive Stock 
                            </h6>
                        </CardTitle>
                    </CardBody>
                    <Table responsive striped className="mb-0">
                        <thead>
                            <tr>
                                <th className="bt-0"></th>
                                <th className="bt-0 text-right">Price</th>
                                <th className="bt-0 text-right">Score</th>
                                <th className="bt-0 text-right">Q</th>
                                <th className="bt-0 text-right">V</th>
                                <th className="bt-0 text-right">G</th>
                            </tr>
                        </thead>
                        <tbody>
                            <TrTableStock />
                        </tbody>
                    </Table>
                </Card>
            </Col>
            </Row>
        </Container>
    );
}

export default setupPage({
    pageTitle: 'Stock'
})(Stock);