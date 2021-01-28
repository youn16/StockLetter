import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
//위젯 코드에서 시작

import {
    Badge,
    Container,
    Col,
    Card,
    CardBody,
    CardDeck,
    Row,
    Table,
} from './../../components'

import { HeaderMain } from "../components/HeaderMain";
import {
    HeaderDemo
} from "../components/HeaderDemo";
import {
    ProfileOverviewCard
} from "../components/Profile/ProfileOverviewCard";

import { getPriceByCode } from '../../modules/price';

export const CustomFin = ( { match }) => {
    
    const { code } = match.params;

    const { data, loading, error } = useSelector(state => state.price.price);
    const dispatch = useDispatch();

    // 컴포넌트 마운트 후 포스트 목록 요청
    useEffect(() => {
        dispatch(getPriceByCode(code));
    }, [dispatch,code]);
    if (loading) return <div>로딩중...</div>;
    if (error) return <div>에러 발생</div>;
    if (!data) return null;

    console.log(data);
    return (
        <Container>
            <HeaderMain 
                title="친절한 재무씨"
                className="mb-5 mt-4"
            />

            { /* START Header 시세정보 */}
            <Row>
                <Col lg={ 12 }>
                    <HeaderDemo 
                        no={1} 
                        title="시세 정보" 
                        subTitle={(
                            <React.Fragment>
                                <strong>시가</strong>, <strong> 고가</strong>, <strong> 저가</strong>
                            </React.Fragment>
                        )}
                    />
                </Col>
            </Row>
            { /* END Header 시세정보 */}
            { /* START Section 시세정보 */}
            <CardDeck>
                { /* 본래 데이터 4개로 하나가 더 있었음 */}
                { /* START Card Widget */}
                <Card className="mb-3">
                    <CardBody>
                        <ProfileOverviewCard 
                            title="시가"
                            badgeTitle="Daily"
                            badgeColor="info"
                            value={data.priceInfo.openPrice}원
                            valueTitle="vs 55.002 prev."
                            footerTitle="Prev"
                            footerTitleClassName="text-danger"
                            footerValue="12%"
                            footerIcon="caret-down"
                        />
                    </CardBody>
                </Card>
                { /* START Card Widget */}
                { /* START Card Widget */}
                <Card className="mb-3">
                    <CardBody>
                        <ProfileOverviewCard 
                            title="고가"
                            badgeTitle="Daily"
                            badgeColor="secondary"
                            value={data.priceInfo.highPrice}원
                            valueTitle="vs 231 prev."
                            footerTitle="Prev"
                            footerTitleClassName="text-success"
                            footerValue="67%"
                            footerIcon="caret-up"
                        />
                    </CardBody>
                </Card>
                { /* START Card Widget */}
                { /* START Card Widget */}
                <Card className="mb-3">
                    <CardBody>
                        <ProfileOverviewCard 
                            title="저가"
                            badgeTitle="Daily"
                            badgeColor="warning"
                            value={data.priceInfo.lowPrice}원
                            valueTitle="vs 87 prev."
                            footerTitle="Prev"
                            footerTitleClassName="text-success"
                            footerValue="8%"
                            footerIcon="caret-up"
                        />
                    </CardBody>
                </Card>
                { /* START Card Widget */}
            </CardDeck>
            { /* END Section 시세정보 */}


            { /* START Header 재무정보 */}
            <Row>
                <Col lg={ 12 }>
                    <HeaderDemo 
                        no={2} 
                        title="재무정보"
                        className="mt-5"
                        subTitle={(
                            <React.Fragment>
                                <strong>안정성비율</strong>, <strong>수익성비율</strong>, <strong> 성장성비율</strong>,<strong> 시장가치비율</strong>
                            </React.Fragment>
                        )}
                    />
                </Col>
            </Row>
            { /* END Header 재무정보 */}
            { /* START Section 재무정보 */}
            <Row className="mb-5">
                
                { /* START 안정성비율 */}

                <Col lg={ 3 }>
                    <div className="hr-text hr-text-center my-2">
                        <span>안정성비율</span>
                    </div>
                    <Row>
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-primary mr-2"></i> 
                                유동비율
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.currentRatio}%
                            </h4>
                        </Col>
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-primary mr-2"></i> 
                                부채비율
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.deptToEquity}%
                            </h4>
                        </Col>
                    </Row>
                </Col>

                { /* START 수익성비율 */}

                <Col lg={ 3 }>
                    <div className="hr-text hr-text-center my-2">
                        <span>수익성비율</span>
                    </div>
                    <Row>
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-info mr-2"></i> 
                                ROE
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.returnOnEquity}%
                            </h4>
                        </Col>
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-info mr-2"></i> 
                                ROA
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.returnOnAsset}%
                            </h4>
                        </Col>
                    </Row>
                    <div className="hr-text hr-text-center mb-2 mt-3">
                    </div>
                    <Row className="mb-4 mb-xl-0">
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-info mr-2"></i> 
                                영업이익율
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.operationProfit}%
                            </h4>
                        </Col>
                    </Row>
                </Col>

                { /* START 성장성비율 */}

                <Col lg={ 3 }>
                    <div className="hr-text hr-text-center my-2">
                        <span>성장성비율</span>
                    </div>
                    <Row>
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-warning mr-2"></i> 
                                매출액증가율
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.revenueGrowth}%
                            </h4>
                        </Col>
                        <Col xs={ 6 } className="text-center">
                            <p className="text-center mb-0">
                                <i className="fa fa-circle text-warning mr-2"></i> 
                                영업<br/>이익증가율
                            </p>
                            <h4 className="mt-2 mb-0">
                                {data.financeInfo.operationIncomeGrowth}%
                            </h4>
                        </Col>
                    </Row>
                </Col>



                { /* START 시장가치비율 */}

                <Col lg={ 3 }>
                    <div className="hr-text hr-text-center my-2">
                        <span>시장가치비율</span>
                    </div>
                    <Table size="sm">
                        <tbody>
                            <tr>
                                <td className="text-inverse bt-0">EPS</td>
                                <td className="text-right bt-0">
                                    <Badge color="success" pill>{data.financeInfo.earningPerShare}원</Badge>
                                </td>
                            </tr>
                            <tr>
                                <td className="text-inverse">PER</td>
                                <td className="text-right">
                                    <Badge color="primary" pill>{data.financeInfo.priceEarningRatio}%</Badge>
                                </td>
                            </tr>
                            <tr>
                                <td className="text-inverse">BPS</td>
                                <td className="text-right">
                                    <Badge color="info" pill>{data.financeInfo.bookvaluePerShare}원</Badge>
                                </td>
                            </tr>
                            <tr>
                                <td className="text-inverse">PBR</td>
                                <td className="text-right">
                                    <Badge color="secondary" pill>{data.financeInfo.priceBookvalueRatio}%</Badge>
                                </td>
                            </tr>
                            <tr>
                                <td className="text-inverse">배당수익률</td>
                                <td className="text-right">
                                    <Badge color="warning" pill>{data.financeInfo.dividendYield}%</Badge>
                                </td>
                            </tr>
                        </tbody>
                    </Table>
                </Col>
            </Row>
            { /* END Section 재무정보 */}

        </Container>
    );


}

export default CustomFin;
