import React from 'react';
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
    TrTableSummary
} from "../../components/Stock/TrTableSummary"

import {
    TrTableStock
} from "../../components/Stock/TrTableStock"

import {
    TrTableFavStock
} from "../../components/Stock/TrTableFavStock"
import { PositiveAndNegativeBarChart } from '../../Graphs/ReCharts/components/PositiveAndNegativeBarChart';

/*eslint-disable */
const progressCompletion = [
    "25",
    "50",
    "75",
    "97"
];
/*eslint-enable */

const Stock = () => {
    return (
    <Container>
        <Row className="mb-2">
            <Col lg={ 12 }>
                <HeaderMain 
                    title="오늘의 구독 정보"
                    className="mb-4 mb-lg-4"
                />
            </Col>
        </Row>
        <Row>
            <Col lg={ 12 }>
                <Table responsive size="sm" className="mb-4 text-nowrap">
                    <thead>
                        <tr>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    구독 요약
                                </h4>
                            </td>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    AAPL
                                </h4>
                                <span className="text-success">
                                    <i className="fa fa-caret-up mr-1"></i> 22.38
                                </span> / 5.9%
                            </td>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    MSFT
                                </h4>
                                <span className="text-danger">
                                    <i className="fa fa-caret-down mr-1"></i> 34.18
                                </span> / 0.56%
                            </td>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    CAT
                                </h4>
                                <span className="text-success">
                                    <i className="fa fa-caret-up mr-1"></i> 22.38
                                </span> / 12.2%
                            </td>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    TSLA
                                </h4>
                                <span className="text-success">
                                    <i className="fa fa-caret-up mr-1"></i> 31.03
                                </span> / 3.2%
                            </td>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    KN
                                </h4>
                                <span className="text-danger">
                                    <i className="fa fa-caret-down mr-1"></i> 34.18
                                </span> / 0.56%
                            </td>
                            <td className="bt-0">
                                <h4 className="mb-1">
                                    QZA
                                </h4>
                                <span className="text-danger">
                                    <i className="fa fa-caret-down mr-1"></i> 4.02
                                </span> / 4.21%
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <TrTableFavStock />
                    </tbody>
                </Table>
            </Col>
            <Col lg={ 6 }>
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

            <Col lg={ 6 }>
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
        </Row>
    </Container>
);
}

export default setupPage({
    pageTitle: 'Stock'
})(Stock);