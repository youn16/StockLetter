import React from 'react';
import PropTypes from 'prop-types';

const FooterText = (props) => (
	<React.Fragment>
		Koscom Team5<br />
		StockLetter<br />
		팀장 : 장효진
	</React.Fragment>
)
FooterText.propTypes = {
    year: PropTypes.node,
	name: PropTypes.node,
	desc: PropTypes.node,
};
FooterText.defaultProps = {
    year: "2018",
    name: "Admin Theme",
    desc: "Bootstrap 4, React 16 (latest) & NPM"
};

export { FooterText };
