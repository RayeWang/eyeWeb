package com.ray.entity;

import java.util.ArrayList;
import java.util.List;

public class CssCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table css
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table css
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table css
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public CssCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table css
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table css
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResLinkIdIsNull() {
            addCriterion("res_link_id is null");
            return (Criteria) this;
        }

        public Criteria andResLinkIdIsNotNull() {
            addCriterion("res_link_id is not null");
            return (Criteria) this;
        }

        public Criteria andResLinkIdEqualTo(Integer value) {
            addCriterion("res_link_id =", value, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdNotEqualTo(Integer value) {
            addCriterion("res_link_id <>", value, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdGreaterThan(Integer value) {
            addCriterion("res_link_id >", value, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_link_id >=", value, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdLessThan(Integer value) {
            addCriterion("res_link_id <", value, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_link_id <=", value, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdIn(List<Integer> values) {
            addCriterion("res_link_id in", values, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdNotIn(List<Integer> values) {
            addCriterion("res_link_id not in", values, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdBetween(Integer value1, Integer value2) {
            addCriterion("res_link_id between", value1, value2, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andResLinkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_link_id not between", value1, value2, "resLinkId");
            return (Criteria) this;
        }

        public Criteria andCsslinkIsNull() {
            addCriterion("csslink is null");
            return (Criteria) this;
        }

        public Criteria andCsslinkIsNotNull() {
            addCriterion("csslink is not null");
            return (Criteria) this;
        }

        public Criteria andCsslinkEqualTo(String value) {
            addCriterion("csslink =", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkNotEqualTo(String value) {
            addCriterion("csslink <>", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkGreaterThan(String value) {
            addCriterion("csslink >", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkGreaterThanOrEqualTo(String value) {
            addCriterion("csslink >=", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkLessThan(String value) {
            addCriterion("csslink <", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkLessThanOrEqualTo(String value) {
            addCriterion("csslink <=", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkLike(String value) {
            addCriterion("csslink like", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkNotLike(String value) {
            addCriterion("csslink not like", value, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkIn(List<String> values) {
            addCriterion("csslink in", values, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkNotIn(List<String> values) {
            addCriterion("csslink not in", values, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkBetween(String value1, String value2) {
            addCriterion("csslink between", value1, value2, "csslink");
            return (Criteria) this;
        }

        public Criteria andCsslinkNotBetween(String value1, String value2) {
            addCriterion("csslink not between", value1, value2, "csslink");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table css
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table css
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}