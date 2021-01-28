import React from 'react';
import { 
    BarChart, 
    CartesianGrid, 
    XAxis, 
    YAxis, 
    Tooltip, 
    ResponsiveContainer,
    ReferenceLine,
    Legend, 
    Bar 
} from './../../../../components/recharts';

import colors from './../../../../colors';

const data = [
      {name: '외국인', 선물: 5565, 현물: -15731, amt: 2400},
      {name: '기관', 선물: 1398, 현물: -3824, amt: 2210},
      {name: '금투', 선물: 833, 현물: -1149, amt: 2290},
      {name: '보험', 선물: 367, 현물: -110, amt: 2000},
      {name: '투신', 선물: -319, 현물: 615, amt: 2181},
      {name: '연기금', 선물: 479, 현물: -2599, amt: 2500},
      {name: '개인', 선물: -5218, 현물: 19392, amt: 2100},
];

const PositiveAndNegativeBarChart = () => (
    <ResponsiveContainer width='100%' aspect={6.0/3.0}>
        <BarChart width={600} height={300} data={data}
            margin={{top: 5, right: 30, left: 20, bottom: 5}}>
           <CartesianGrid strokeDasharray="3 3"/>
           <XAxis dataKey="name"/>
           <YAxis/>
           <Tooltip/>
           <Legend />
           <ReferenceLine y={0} stroke={ colors['400'] } />
           <Bar dataKey="선물" fill={ colors['primary'] } barSize={ 5 } />
           <Bar dataKey="현물" fill={ colors['purple'] } barSize={ 5 } />
      </BarChart>
    </ResponsiveContainer>

)

export { PositiveAndNegativeBarChart };
