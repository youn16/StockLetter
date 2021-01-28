import React, { useState } from 'react';
import faker from 'faker/locale/en_US';
import PropTypes from 'prop-types';

import { 
    ButtonGroup,
    Button,
    Card,
    CardImg,
    CardText,
    CardBody,
    CardTitle,
    CardFooter,
    HolderProvider,
    UncontrolledTooltip,
    UncontrolledCollapse,
    ListGroup,
    ListGroupItem
} from './../../../components';


const status = [
    "success",
    "danger",
    "warning",
    "secondary"
];
const badges = [
    "secondary"
];

const ReportCard = ({ data , id}) => {
    console.log(data)
    return (
        <React.Fragment>
            { /* START Card */}
            <Card className="mb-3">
                <CardBody>
                    <h4 className="align-self-center mb-0">
                        { data.title }
                    </h4>
                </CardBody>
                <div className="hr-text hr-text-center my-2"></div>
                <CardBody className="pt-0">
                    <CardText>
                        <span className="mr-2">
                            { data.description }
                        </span>
                    </CardText>
                </CardBody>
            <CardFooter className="small">
                    <i className="fa fa-fw fa-info-circle mr-2"></i>
                    <a href={data.link}><abbr title="원본">뉴스 기사를 더 보고 싶다면 여기를 눌러주세요</abbr></a>
            </CardFooter>
            {/*Custom Part*/}

            </Card>
            { /* END Card */}
        </React.Fragment>
    )
}
ReportCard.propTypes = {
    id: PropTypes.node
};
ReportCard.defaultProps = {
    id: "1"
};

export { ReportCard };
