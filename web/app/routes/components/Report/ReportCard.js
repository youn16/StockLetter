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
    HolderProvider,
    UncontrolledTooltip,
    UncontrolledCollapse,
    ListGroup,
    ListGroupItem
} from './../../../components';

import { randomArray, randomAvatar } from './../../../utilities';

const status = [
    "success",
    "danger",
    "warning",
    "secondary"
];
const badges = [
    "secondary"
];

const ReportCard = (props) => {
    
    const [isOpen, setIsOpen] = useState(false);

    const toggle = () => setIsOpen(!isOpen);
    return (
        <React.Fragment>
            { /* START Card */}
            <Card className="mb-3">
                {/* 이미지 대기혹은 이미지가 없는 경우 넣는 것*/}
                <HolderProvider.Icon
                    iconChar=""
                    size={ 32 }
                >
                <CardImg top />
                </HolderProvider.Icon>
                <CardBody>
                    <span className="d-flex">
                        <CardTitle tag="h6">
                            제목이다. 삼성전자 뉴스 어쩌고
                        </CardTitle>
                        <ButtonGroup className="ml-auto" size="sm">
                            <Button outline>
                                <i className="fa fa-star-o"></i>
                            </Button>
                            <Button outline>
                                <i className="fa fa-star"></i>
                            </Button>
                        </ButtonGroup>
                    </span>
                </CardBody>
                <ListGroup flush>
                    <ListGroupItem tag="a" href="#" id="RamToggler" className="by-0 d-flex text-decoration-none">
                        더보기
                        <i onClick={toggle} className="fa fa-fw fa-angle-down ml-auto justify-content-end" id="RamTooltip"></i>
                    </ListGroupItem>
                    <UncontrolledTooltip placement="top" target="RamTooltip">
                        Show/Hide News
                    </UncontrolledTooltip>
                </ListGroup>
                <UncontrolledCollapse toggler="#RamToggler" isOpen={isOpen}>
                    <CardBody className="pt-0">
                        <CardText>
                            <span className="mr-2 text-muted">
                                <br />
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nisl elit, porta a sapien eget, fringilla sagittis ex.
                            </span>
                        </CardText>
                    </CardBody>
                </UncontrolledCollapse>

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
