import React from 'react';
import { Link } from 'react-router-dom';
import faker from 'faker/locale/en_US';

//위젯 코드에서 시작

import {
    Badge,
    Container,
    Col,
    Card,
    CardBody,
    CardDeck,
    Media,
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


import {
    TinyDonutChart
} from "../components/ProjectsDashboards/TinyDonutChart"
import {
    TinyDonutChartAllProjects
} from "../components/ProjectsDashboards/TinyDonutChartAllProjects"


export const CustomFin = () => (
    <Container>
        <HeaderMain 
            title="Financial"
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
                        value="75.938"
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
                        value="456"
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
                        value="91"
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
                            <strong>시가</strong>, <strong> 고가</strong>, <strong> 저가</strong>
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
                            Today
                        </p>
                        <h4 className="mt-2 mb-0">
                            $3,267
                        </h4>
                    </Col>
                    <Col xs={ 6 } className="text-center">
                        <p className="text-center mb-0">
                            <i className="fa fa-circle text-primary mr-2"></i> 
                            This Month
                        </p>
                        <h4 className="mt-2 mb-0">
                            $8,091
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
                            Today
                        </p>
                        <h4 className="mt-2 mb-0">
                            $3,267
                        </h4>
                    </Col>
                    <Col xs={ 6 } className="text-center">
                        <p className="text-center mb-0">
                            <i className="fa fa-circle text-info mr-2"></i> 
                            This Month
                        </p>
                        <h4 className="mt-2 mb-0">
                            $8,091
                        </h4>
                    </Col>
                </Row>
                <div className="hr-text hr-text-center mb-2 mt-3">
                </div>
                <Row className="mb-4 mb-xl-0">
                    <Col xs={ 6 } className="text-center">
                        <p className="text-center mb-0">
                            <i className="fa fa-circle text-info mr-2"></i> 
                            Due
                        </p>
                        <h4 className="mt-2 mb-0">
                            $4,007
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
                            Today
                        </p>
                        <h4 className="mt-2 mb-0">
                            $3,267
                        </h4>
                    </Col>
                    <Col xs={ 6 } className="text-center">
                        <p className="text-center mb-0">
                            <i className="fa fa-circle text-warning mr-2"></i> 
                            This Month
                        </p>
                        <h4 className="mt-2 mb-0">
                            $8,091
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
                            <td className="text-inverse bt-0">Active Projects</td>
                            <td className="text-right bt-0">
                                <Badge color="success" pill>6</Badge>
                            </td>
                        </tr>
                        <tr>
                            <td className="text-inverse">Open Tasks</td>
                            <td className="text-right">
                                <Badge color="primary" pill>4</Badge>
                            </td>
                        </tr>
                        <tr>
                            <td className="text-inverse">Support Tickets</td>
                            <td className="text-right">
                                <Badge color="info" pill>15</Badge>
                            </td>
                        </tr>
                        <tr>
                            <td className="text-inverse">Active Timers</td>
                            <td className="text-right">
                                <Badge color="secondary" pill>0</Badge>
                            </td>
                        </tr>
                        <tr>
                            <td className="text-inverse">Active Timers</td>
                            <td className="text-right">
                                <Badge color="warning" pill>1000</Badge>
                            </td>
                        </tr>
                    </tbody>
                </Table>
            </Col>
        </Row>
        { /* END Section 재무정보 */}

    </Container>
);

export default CustomFin;