//사이드바 조정
import { SidebarMenu } from './../../components';
import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getSubscribes } from '../../modules/subscribes';

export const SidebarMiddleNav = () => {
    const { data, loading, error } = useSelector(state => state.subscribes.subscribes);
    const dispatch = useDispatch();
  
    // 컴포넌트 마운트 후 포스트 목록 요청
    useEffect(() => {
        dispatch(getSubscribes());
    }, [dispatch]);


    if (loading) return <div>로딩중...</div>;
    if (error) return <div>에러 발생</div>;
    if (!data) return null;

    return (
    <SidebarMenu>
        <SidebarMenu.Item
            icon={<i className="fa fa-fw fa-home"></i>}
            title="총 망라"
        >
            <SidebarMenu.Item title="오늘의 구독 정보" to='/dashboards/stock' exact />
        </SidebarMenu.Item>

        { /* -------- Custom Stock List ---------*/ }

        {data.map( sub => (
            <SidebarMenu.Item 
                icon={<i className="fa fa-fw fa-area-chart"></i>}
                title={sub.stockName}
            >
                <SidebarMenu.Item title="Financial" to={`/customfin/${sub.stockCode}`} />
                <SidebarMenu.Item title="News" to="/apps/report-grid" />
            </SidebarMenu.Item>
        ))}

    </SidebarMenu >
);

}
