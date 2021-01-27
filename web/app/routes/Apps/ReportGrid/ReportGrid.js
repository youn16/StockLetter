import React, { useEffect, useState } from 'react';
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
import axios from 'axios';

const ReportGrid = () => {

    return (
        <Container>
            <HeaderMain 
                title="News"
                className="mb-5 mt-4"
            />
            { /* START Content */}
            <Row>
                <Col lg={ 12 }>
                    { /*
                    <ProjectsSmHeader 
                        subTitle="ReportGrid"
                        linkList="/apps/gallery-table"
                        linkGrid="/apps/gallery-grid"
                    />
                    */ }
                    <CardColumns>
                        <ReportCard />
                        <ReportCard 
                            id="2"
                        />
                        <ReportCard 
                            id="3"
                        />
                        <ReportCard 
                            id="4"
                        />
                        <ReportCard 
                            id="5"
                        />
                        <ReportCard 
                            id="6"
                        />
                        <ReportCard 
                            id="7"
                        />
                        <ReportCard 
                            id="8"
                        />
                        <ReportCard 
                            id="9"
                        />
                    </CardColumns>
                    <div className="d-flex justify-content-center">
                        <Paginations />
                    </div>
                </Col>
            </Row>
            { /* END Content */}
        </Container>
    );
};

export default ReportGrid;