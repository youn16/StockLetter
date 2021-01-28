import React from 'react';
import { 
    Line, 
    CartesianGrid, 
    XAxis, 
    YAxis, 
    Tooltip, 
    ResponsiveContainer,
    Legend, 
    LineChart,
    Dot,
} from './../../../components/recharts';

import colors from './../../../colors';

const data = [
        {name: 'Jan \'19', uv: 3798.91, pv: 3092.66, amt: 3566.38},
        {name: 'Jan \'20', uv: 3851.85, pv: 3114.55, amt: 3583.09},
        {name: 'Jan \'21', uv: 3853.07, pv: 3160.84, amt: 3621.26},
        {name: 'Jan \'22', uv: 3841.47, pv: 3140.63, amt: 3606.75},
        {name: 'Jan \'25', uv: 3855.36, pv: 3208.99, amt: 3569.43},
        {name: 'Jan \'26', uv: 3849.62, pv: 3140.31, amt: 3569.43},
        {name: 'Jan \'27', uv: 3750.77, pv: 3122.56, amt: 3573.34},
];

// eslint-disable-next-line
const generateDot = ({stroke, ...other}) => (
    <Dot
        { ...other }
        fill={ stroke }
        stroke={ colors['white'] }
        r={ 4 }
        strokeWidth={ 2 }
    />
);

const generateActiveDot = (props) => (
    <Dot
        { ...props }
        stroke={ colors['white'] }
        r={ 7 }
    />
);

const SimpleLineChart = () => (
    <ResponsiveContainer width='100%' aspect={6.0/3.0}>
        <LineChart data={data}
            margin={{top: 5, right: 30, left: 20, bottom: 5}}>
           <XAxis dataKey="name"/>
           <YAxis domain={[3000,4000]}/>
           <CartesianGrid strokeDasharray="3 3"/>
           <Tooltip/>
           <Legend />
           <Line dataKey="pv" stroke={ colors['success'] } dot={generateDot} activeDot={generateActiveDot} name='코스피' />
           <Line dataKey="uv" stroke={ colors['purple'] } dot={generateDot} activeDot={generateActiveDot} name='SnP500' />
           <Line dataKey="amt" stroke={ colors['blue'] } dot={generateDot} activeDot={generateActiveDot} name='상해종합' />
      </LineChart>
    </ResponsiveContainer>
);

export { SimpleLineChart };
