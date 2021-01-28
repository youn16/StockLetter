import React from 'react';
import _ from 'lodash';
import { randomArray } from './../../../utilities';
import {
    Badge
} from './../../../components';

const name = [
    "시장종류",
    "현재가",
    "전날 종가",
    "증감"
];

const TrTableFavStock = ({data}) => {
    console.log(data);
    return (
        <React.Fragment>
            {
                data.map((sub, index) => (
                    <td key={ index }>
                        <tr className="align-middle">
                            <Badge pill className="text-uppercase mr-1"> { "m" } </Badge> <span className="text-inverse">{ sub.marketType }</span>
                        </tr>
                        <tr className="align-middle">
                            <Badge pill className="text-uppercase mr-1"> { "c" } </Badge> <span className="text-inverse">{ sub.stockPrice }</span>
                        </tr>
                        <tr className="align-middle">
                            <Badge pill className="text-uppercase mr-1"> { "e" } </Badge> <span className="text-inverse">{ sub.priorPrice }</span>
                        </tr>
                        <tr className="align-middle">
                            <Badge pill className="text-uppercase mr-1"> { "d" } </Badge> <span className="text-inverse">{ sub.difference }</span>
                        </tr>
                    </td>
                ))
            }
        </React.Fragment>)
}

export { TrTableFavStock };
