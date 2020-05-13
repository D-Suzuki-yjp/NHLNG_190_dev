package job.common.nhlngCommon.dataAccess.entity.nhlng;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================== MODIFICATION HISTORY ==========================
 * Release  Date       ID/Name                   Comment
 * --------------------------------------------------------------------------
 * R0.01.01 2020/04/01 30042453/D.Suzuki         初版
 * [END OF MODIFICATION HISTORY]
 * ==========================================================================
 *
 * CmmTagMasterV NHタグマスタ(ビュー)entityExample
 * ジェネレータがviewからは生成しないので手動作成
 * @author D.Suzuki
 */
public class CmmTagMasterVExampleForExtend {

    protected String orderByClauseEx;

    protected boolean distinctEx;


    protected List<CriteriaEx> oredCriteriaEx;

    public CmmTagMasterVExampleForExtend() {
        oredCriteriaEx = new ArrayList<CriteriaEx>();
    }

    public void setOrderByClauseEx(String orderByClauseEx) {
        this.orderByClauseEx = orderByClauseEx;
    }

    public String getOrderByClauseEx() {
        return orderByClauseEx;
    }

    public void setDistinctEx(boolean distinctEx) {
        this.distinctEx = distinctEx;
    }

    public boolean isDistinctEx() {
        return distinctEx;
    }

    public List<CriteriaEx> getOredCriteriaEx() {
        return oredCriteriaEx;
    }

    public void or(CriteriaEx criteria) {
        oredCriteriaEx.add(criteria);
    }

    public CriteriaEx orEx() {
    	CriteriaEx criteria = createCriteriaInternalEx();
        oredCriteriaEx.add(criteria);
        return criteria;
    }

    public CriteriaEx createCriteriaEx() {
    	CriteriaEx criteria = createCriteriaInternalEx();
        if (oredCriteriaEx.size() == 0) {
            oredCriteriaEx.add(criteria);
        }
        return criteria;
    }

    protected CriteriaEx createCriteriaInternalEx() {
    	CriteriaEx criteria = new CriteriaEx();
        return criteria;
    }

    public void clearEx() {
        oredCriteriaEx.clear();
        orderByClauseEx = null;
        distinctEx = false;
    }

    protected abstract static class GeneratedCriteriaTagM {
        protected List<CriterionEx> criteriaEx;

        protected GeneratedCriteriaTagM() {
            super();
            criteriaEx = new ArrayList<CriterionEx>();
        }

        public boolean isValid() {
            return criteriaEx.size() > 0;
        }

        public List<CriterionEx> getAllCriteriaEx() {
            return criteriaEx;
        }

        public List<CriterionEx> getCriteriaEx() {
            return criteriaEx;
        }

        protected void addCriterionEx(String conditionEx) {
            if (conditionEx == null) {
                throw new RuntimeException("Value for conditionEx cannot be null");
            }
            criteriaEx.add(new CriterionEx(conditionEx));
        }

        protected void addCriterionEx(String conditionEx, Object valueEx, String property) {
            if (valueEx == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteriaEx.add(new CriterionEx(conditionEx, valueEx));
        }

        protected void addCriterionEx(String conditionEx, Object valueEx1, Object valueEx2, String property) {
            if (valueEx1 == null || valueEx2 == null) {
                throw new RuntimeException("Between valueExs for " + property + " cannot be null");
            }
            criteriaEx.add(new CriterionEx(conditionEx, valueEx1, valueEx2));
        }

        public CriteriaEx andLcodeIsNull() {
            addCriterionEx("lcode is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeIsNotNull() {
            addCriterionEx("lcode is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeEqualTo(String valueEx) {
            addCriterionEx("lcode =", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeNotEqualTo(String valueEx) {
            addCriterionEx("lcode <>", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeGreaterThan(String valueEx) {
            addCriterionEx("lcode >", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("lcode >=", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeLessThan(String valueEx) {
            addCriterionEx("lcode <", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeLessThanOrEqualTo(String valueEx) {
            addCriterionEx("lcode <=", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeLike(String valueEx) {
            addCriterionEx("lcode like", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeNotLike(String valueEx) {
            addCriterionEx("lcode not like", valueEx, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeIn(List<String> valueExs) {
            addCriterionEx("lcode in", valueExs, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeNotIn(List<String> valueExs) {
            addCriterionEx("lcode not in", valueExs, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeBetween(String valueEx1, String valueEx2) {
            addCriterionEx("lcode between", valueEx1, valueEx2, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLcodeNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("lcode not between", valueEx1, valueEx2, "lcode");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1IsNull() {
            addCriterionEx("comment1 is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1IsNotNull() {
            addCriterionEx("comment1 is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1EqualTo(String valueEx) {
            addCriterionEx("comment1 =", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1NotEqualTo(String valueEx) {
            addCriterionEx("comment1 <>", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1GreaterThan(String valueEx) {
            addCriterionEx("comment1 >", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1GreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("comment1 >=", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1LessThan(String valueEx) {
            addCriterionEx("comment1 <", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1LessThanOrEqualTo(String valueEx) {
            addCriterionEx("comment1 <=", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1Like(String valueEx) {
            addCriterionEx("comment1 like", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1NotLike(String valueEx) {
            addCriterionEx("comment1 not like", valueEx, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1In(List<String> valueExs) {
            addCriterionEx("comment1 in", valueExs, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1NotIn(List<String> valueExs) {
            addCriterionEx("comment1 not in", valueExs, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1Between(String valueEx1, String valueEx2) {
            addCriterionEx("comment1 between", valueEx1, valueEx2, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andComment1NotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("comment1 not between", valueEx1, valueEx2, "comment1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerIsNull() {
            addCriterionEx("unit_computer is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerIsNotNull() {
            addCriterionEx("unit_computer is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerEqualTo(String valueEx) {
            addCriterionEx("unit_computer =", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerNotEqualTo(String valueEx) {
            addCriterionEx("unit_computer <>", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerGreaterThan(String valueEx) {
            addCriterionEx("unit_computer >", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("unit_computer >=", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerLessThan(String valueEx) {
            addCriterionEx("unit_computer <", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerLessThanOrEqualTo(String valueEx) {
            addCriterionEx("unit_computer <=", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerLike(String valueEx) {
            addCriterionEx("unit_computer like", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerNotLike(String valueEx) {
            addCriterionEx("unit_computer not like", valueEx, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerIn(List<String> valueExs) {
            addCriterionEx("unit_computer in", valueExs, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerNotIn(List<String> valueExs) {
            addCriterionEx("unit_computer not in", valueExs, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerBetween(String valueEx1, String valueEx2) {
            addCriterionEx("unit_computer between", valueEx1, valueEx2, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUnitComputerNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("unit_computer not between", valueEx1, valueEx2, "unitComputer");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpIsNull() {
            addCriterionEx("dp is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpIsNotNull() {
            addCriterionEx("dp is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpEqualTo(Integer valueEx) {
            addCriterionEx("dp =", valueEx, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpNotEqualTo(Integer valueEx) {
            addCriterionEx("dp <>", valueEx, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpGreaterThan(Integer valueEx) {
            addCriterionEx("dp >", valueEx, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("dp >=", valueEx, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpLessThan(Integer valueEx) {
            addCriterionEx("dp <", valueEx, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("dp <=", valueEx, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpIn(List<Integer> valueExs) {
            addCriterionEx("dp in", valueExs, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpNotIn(List<Integer> valueExs) {
            addCriterionEx("dp not in", valueExs, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("dp between", valueEx1, valueEx2, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDpNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("dp not between", valueEx1, valueEx2, "dp");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueIsNull() {
            addCriterionEx("upper_valueEx is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueIsNotNull() {
            addCriterionEx("upper_valueEx is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueEqualTo(Float valueEx) {
            addCriterionEx("upper_valueEx =", valueEx, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueNotEqualTo(Float valueEx) {
            addCriterionEx("upper_valueEx <>", valueEx, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueGreaterThan(Float valueEx) {
            addCriterionEx("upper_valueEx >", valueEx, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueGreaterThanOrEqualTo(Float valueEx) {
            addCriterionEx("upper_valueEx >=", valueEx, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueLessThan(Float valueEx) {
            addCriterionEx("upper_valueEx <", valueEx, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueLessThanOrEqualTo(Float valueEx) {
            addCriterionEx("upper_valueEx <=", valueEx, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueIn(List<Float> valueExs) {
            addCriterionEx("upper_valueEx in", valueExs, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueNotIn(List<Float> valueExs) {
            addCriterionEx("upper_valueEx not in", valueExs, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueBetween(Float valueEx1, Float valueEx2) {
            addCriterionEx("upper_valueEx between", valueEx1, valueEx2, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andUpperValueNotBetween(Float valueEx1, Float valueEx2) {
            addCriterionEx("upper_valueEx not between", valueEx1, valueEx2, "upperValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueIsNull() {
            addCriterionEx("lower_valueEx is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueIsNotNull() {
            addCriterionEx("lower_valueEx is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueEqualTo(Float valueEx) {
            addCriterionEx("lower_valueEx =", valueEx, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueNotEqualTo(Float valueEx) {
            addCriterionEx("lower_valueEx <>", valueEx, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueGreaterThan(Float valueEx) {
            addCriterionEx("lower_valueEx >", valueEx, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueGreaterThanOrEqualTo(Float valueEx) {
            addCriterionEx("lower_valueEx >=", valueEx, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueLessThan(Float valueEx) {
            addCriterionEx("lower_valueEx <", valueEx, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueLessThanOrEqualTo(Float valueEx) {
            addCriterionEx("lower_valueEx <=", valueEx, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueIn(List<Float> valueExs) {
            addCriterionEx("lower_valueEx in", valueExs, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueNotIn(List<Float> valueExs) {
            addCriterionEx("lower_valueEx not in", valueExs, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueBetween(Float valueEx1, Float valueEx2) {
            addCriterionEx("lower_valueEx between", valueEx1, valueEx2, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andLowerValueNotBetween(Float valueEx1, Float valueEx2) {
            addCriterionEx("lower_valueEx not between", valueEx1, valueEx2, "lowerValue");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindIsNull() {
            addCriterionEx("tag_kind is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindIsNotNull() {
            addCriterionEx("tag_kind is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindEqualTo(Integer valueEx) {
            addCriterionEx("tag_kind =", valueEx, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindNotEqualTo(Integer valueEx) {
            addCriterionEx("tag_kind <>", valueEx, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindGreaterThan(Integer valueEx) {
            addCriterionEx("tag_kind >", valueEx, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("tag_kind >=", valueEx, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindLessThan(Integer valueEx) {
            addCriterionEx("tag_kind <", valueEx, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("tag_kind <=", valueEx, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindIn(List<Integer> valueExs) {
            addCriterionEx("tag_kind in", valueExs, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindNotIn(List<Integer> valueExs) {
            addCriterionEx("tag_kind not in", valueExs, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("tag_kind between", valueEx1, valueEx2, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagKindNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("tag_kind not between", valueEx1, valueEx2, "tagKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindIsNull() {
            addCriterionEx("io_kind is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindIsNotNull() {
            addCriterionEx("io_kind is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindEqualTo(String valueEx) {
            addCriterionEx("io_kind =", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindNotEqualTo(String valueEx) {
            addCriterionEx("io_kind <>", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindGreaterThan(String valueEx) {
            addCriterionEx("io_kind >", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("io_kind >=", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindLessThan(String valueEx) {
            addCriterionEx("io_kind <", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindLessThanOrEqualTo(String valueEx) {
            addCriterionEx("io_kind <=", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindLike(String valueEx) {
            addCriterionEx("io_kind like", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindNotLike(String valueEx) {
            addCriterionEx("io_kind not like", valueEx, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindIn(List<String> valueExs) {
            addCriterionEx("io_kind in", valueExs, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindNotIn(List<String> valueExs) {
            addCriterionEx("io_kind not in", valueExs, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindBetween(String valueEx1, String valueEx2) {
            addCriterionEx("io_kind between", valueEx1, valueEx2, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andIoKindNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("io_kind not between", valueEx1, valueEx2, "ioKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivIsNull() {
            addCriterionEx("const_div is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivIsNotNull() {
            addCriterionEx("const_div is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivEqualTo(String valueEx) {
            addCriterionEx("const_div =", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivNotEqualTo(String valueEx) {
            addCriterionEx("const_div <>", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivGreaterThan(String valueEx) {
            addCriterionEx("const_div >", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("const_div >=", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivLessThan(String valueEx) {
            addCriterionEx("const_div <", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivLessThanOrEqualTo(String valueEx) {
            addCriterionEx("const_div <=", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivLike(String valueEx) {
            addCriterionEx("const_div like", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivNotLike(String valueEx) {
            addCriterionEx("const_div not like", valueEx, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivIn(List<String> valueExs) {
            addCriterionEx("const_div in", valueExs, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivNotIn(List<String> valueExs) {
            addCriterionEx("const_div not in", valueExs, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivBetween(String valueEx1, String valueEx2) {
            addCriterionEx("const_div between", valueEx1, valueEx2, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andConstDivNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("const_div not between", valueEx1, valueEx2, "constDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivIsNull() {
            addCriterionEx("repo_div is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivIsNotNull() {
            addCriterionEx("repo_div is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivEqualTo(String valueEx) {
            addCriterionEx("repo_div =", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivNotEqualTo(String valueEx) {
            addCriterionEx("repo_div <>", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivGreaterThan(String valueEx) {
            addCriterionEx("repo_div >", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("repo_div >=", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivLessThan(String valueEx) {
            addCriterionEx("repo_div <", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivLessThanOrEqualTo(String valueEx) {
            addCriterionEx("repo_div <=", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivLike(String valueEx) {
            addCriterionEx("repo_div like", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivNotLike(String valueEx) {
            addCriterionEx("repo_div not like", valueEx, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivIn(List<String> valueExs) {
            addCriterionEx("repo_div in", valueExs, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivNotIn(List<String> valueExs) {
            addCriterionEx("repo_div not in", valueExs, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivBetween(String valueEx1, String valueEx2) {
            addCriterionEx("repo_div between", valueEx1, valueEx2, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoDivNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("repo_div not between", valueEx1, valueEx2, "repoDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivIsNull() {
            addCriterionEx("repo_calc_div is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivIsNotNull() {
            addCriterionEx("repo_calc_div is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivEqualTo(String valueEx) {
            addCriterionEx("repo_calc_div =", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivNotEqualTo(String valueEx) {
            addCriterionEx("repo_calc_div <>", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivGreaterThan(String valueEx) {
            addCriterionEx("repo_calc_div >", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("repo_calc_div >=", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivLessThan(String valueEx) {
            addCriterionEx("repo_calc_div <", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivLessThanOrEqualTo(String valueEx) {
            addCriterionEx("repo_calc_div <=", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivLike(String valueEx) {
            addCriterionEx("repo_calc_div like", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivNotLike(String valueEx) {
            addCriterionEx("repo_calc_div not like", valueEx, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivIn(List<String> valueExs) {
            addCriterionEx("repo_calc_div in", valueExs, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivNotIn(List<String> valueExs) {
            addCriterionEx("repo_calc_div not in", valueExs, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivBetween(String valueEx1, String valueEx2) {
            addCriterionEx("repo_calc_div between", valueEx1, valueEx2, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRepoCalcDivNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("repo_calc_div not between", valueEx1, valueEx2, "repoCalcDiv");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagIsNull() {
            addCriterionEx("odb_min_snd_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagIsNotNull() {
            addCriterionEx("odb_min_snd_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagEqualTo(Integer valueEx) {
            addCriterionEx("odb_min_snd_flag =", valueEx, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("odb_min_snd_flag <>", valueEx, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagGreaterThan(Integer valueEx) {
            addCriterionEx("odb_min_snd_flag >", valueEx, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("odb_min_snd_flag >=", valueEx, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagLessThan(Integer valueEx) {
            addCriterionEx("odb_min_snd_flag <", valueEx, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("odb_min_snd_flag <=", valueEx, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagIn(List<Integer> valueExs) {
            addCriterionEx("odb_min_snd_flag in", valueExs, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("odb_min_snd_flag not in", valueExs, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("odb_min_snd_flag between", valueEx1, valueEx2, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbMinSndFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("odb_min_snd_flag not between", valueEx1, valueEx2, "odbMinSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagIsNull() {
            addCriterionEx("odb_hour_snd_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagIsNotNull() {
            addCriterionEx("odb_hour_snd_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagEqualTo(Integer valueEx) {
            addCriterionEx("odb_hour_snd_flag =", valueEx, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("odb_hour_snd_flag <>", valueEx, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagGreaterThan(Integer valueEx) {
            addCriterionEx("odb_hour_snd_flag >", valueEx, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("odb_hour_snd_flag >=", valueEx, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagLessThan(Integer valueEx) {
            addCriterionEx("odb_hour_snd_flag <", valueEx, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("odb_hour_snd_flag <=", valueEx, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagIn(List<Integer> valueExs) {
            addCriterionEx("odb_hour_snd_flag in", valueExs, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("odb_hour_snd_flag not in", valueExs, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("odb_hour_snd_flag between", valueEx1, valueEx2, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbHourSndFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("odb_hour_snd_flag not between", valueEx1, valueEx2, "odbHourSndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagIsNull() {
            addCriterionEx("odb_day_snd_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagIsNotNull() {
            addCriterionEx("odb_day_snd_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagEqualTo(Integer valueEx) {
            addCriterionEx("odb_day_snd_flag =", valueEx, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("odb_day_snd_flag <>", valueEx, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagGreaterThan(Integer valueEx) {
            addCriterionEx("odb_day_snd_flag >", valueEx, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("odb_day_snd_flag >=", valueEx, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagLessThan(Integer valueEx) {
            addCriterionEx("odb_day_snd_flag <", valueEx, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("odb_day_snd_flag <=", valueEx, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagIn(List<Integer> valueExs) {
            addCriterionEx("odb_day_snd_flag in", valueExs, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("odb_day_snd_flag not in", valueExs, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("odb_day_snd_flag between", valueEx1, valueEx2, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andOdbDaySndFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("odb_day_snd_flag not between", valueEx1, valueEx2, "odbDaySndFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagIsNull() {
            addCriterionEx("round_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagIsNotNull() {
            addCriterionEx("round_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagEqualTo(Integer valueEx) {
            addCriterionEx("round_flag =", valueEx, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("round_flag <>", valueEx, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagGreaterThan(Integer valueEx) {
            addCriterionEx("round_flag >", valueEx, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("round_flag >=", valueEx, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagLessThan(Integer valueEx) {
            addCriterionEx("round_flag <", valueEx, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("round_flag <=", valueEx, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagIn(List<Integer> valueExs) {
            addCriterionEx("round_flag in", valueExs, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("round_flag not in", valueExs, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("round_flag between", valueEx1, valueEx2, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRoundFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("round_flag not between", valueEx1, valueEx2, "roundFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoIsNull() {
            addCriterionEx("rem_tag_no is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoIsNotNull() {
            addCriterionEx("rem_tag_no is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoEqualTo(String valueEx) {
            addCriterionEx("rem_tag_no =", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoNotEqualTo(String valueEx) {
            addCriterionEx("rem_tag_no <>", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoGreaterThan(String valueEx) {
            addCriterionEx("rem_tag_no >", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoGreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("rem_tag_no >=", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoLessThan(String valueEx) {
            addCriterionEx("rem_tag_no <", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoLessThanOrEqualTo(String valueEx) {
            addCriterionEx("rem_tag_no <=", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoLike(String valueEx) {
            addCriterionEx("rem_tag_no like", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoNotLike(String valueEx) {
            addCriterionEx("rem_tag_no not like", valueEx, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoIn(List<String> valueExs) {
            addCriterionEx("rem_tag_no in", valueExs, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoNotIn(List<String> valueExs) {
            addCriterionEx("rem_tag_no not in", valueExs, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoBetween(String valueEx1, String valueEx2) {
            addCriterionEx("rem_tag_no between", valueEx1, valueEx2, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andRemTagNoNotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("rem_tag_no not between", valueEx1, valueEx2, "remTagNo");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagIsNull() {
            addCriterionEx("scr_update_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagIsNotNull() {
            addCriterionEx("scr_update_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagEqualTo(Integer valueEx) {
            addCriterionEx("scr_update_flag =", valueEx, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("scr_update_flag <>", valueEx, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagGreaterThan(Integer valueEx) {
            addCriterionEx("scr_update_flag >", valueEx, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("scr_update_flag >=", valueEx, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagLessThan(Integer valueEx) {
            addCriterionEx("scr_update_flag <", valueEx, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("scr_update_flag <=", valueEx, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagIn(List<Integer> valueExs) {
            addCriterionEx("scr_update_flag in", valueExs, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("scr_update_flag not in", valueExs, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("scr_update_flag between", valueEx1, valueEx2, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andScrUpdateFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("scr_update_flag not between", valueEx1, valueEx2, "scrUpdateFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1IsNull() {
            addCriterionEx("tag_logic_name1 is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1IsNotNull() {
            addCriterionEx("tag_logic_name1 is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1EqualTo(String valueEx) {
            addCriterionEx("tag_logic_name1 =", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1NotEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name1 <>", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1GreaterThan(String valueEx) {
            addCriterionEx("tag_logic_name1 >", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1GreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name1 >=", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1LessThan(String valueEx) {
            addCriterionEx("tag_logic_name1 <", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1LessThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name1 <=", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1Like(String valueEx) {
            addCriterionEx("tag_logic_name1 like", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1NotLike(String valueEx) {
            addCriterionEx("tag_logic_name1 not like", valueEx, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1In(List<String> valueExs) {
            addCriterionEx("tag_logic_name1 in", valueExs, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1NotIn(List<String> valueExs) {
            addCriterionEx("tag_logic_name1 not in", valueExs, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1Between(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name1 between", valueEx1, valueEx2, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andTagLogicName1NotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name1 not between", valueEx1, valueEx2, "tagLogicName1");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2IsNull() {
            addCriterionEx("tag_logic_name2 is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2IsNotNull() {
            addCriterionEx("tag_logic_name2 is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2EqualTo(String valueEx) {
            addCriterionEx("tag_logic_name2 =", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2NotEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name2 <>", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2GreaterThan(String valueEx) {
            addCriterionEx("tag_logic_name2 >", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2GreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name2 >=", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2LessThan(String valueEx) {
            addCriterionEx("tag_logic_name2 <", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2LessThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name2 <=", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2Like(String valueEx) {
            addCriterionEx("tag_logic_name2 like", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2NotLike(String valueEx) {
            addCriterionEx("tag_logic_name2 not like", valueEx, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2In(List<String> valueExs) {
            addCriterionEx("tag_logic_name2 in", valueExs, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2NotIn(List<String> valueExs) {
            addCriterionEx("tag_logic_name2 not in", valueExs, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2Between(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name2 between", valueEx1, valueEx2, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote2NotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name2 not between", valueEx1, valueEx2, "tagLogicName2");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3IsNull() {
            addCriterionEx("tag_logic_name3 is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3IsNotNull() {
            addCriterionEx("tag_logic_name3 is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3EqualTo(String valueEx) {
            addCriterionEx("tag_logic_name3 =", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3NotEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name3 <>", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3GreaterThan(String valueEx) {
            addCriterionEx("tag_logic_name3 >", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3GreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name3 >=", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3LessThan(String valueEx) {
            addCriterionEx("tag_logic_name3 <", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3LessThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name3 <=", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3Like(String valueEx) {
            addCriterionEx("tag_logic_name3 like", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3NotLike(String valueEx) {
            addCriterionEx("tag_logic_name3 not like", valueEx, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3In(List<String> valueExs) {
            addCriterionEx("tag_logic_name3 in", valueExs, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3NotIn(List<String> valueExs) {
            addCriterionEx("tag_logic_name3 not in", valueExs, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3Between(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name3 between", valueEx1, valueEx2, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote3NotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name3 not between", valueEx1, valueEx2, "tagLogicName3");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4IsNull() {
            addCriterionEx("tag_logic_name4 is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4IsNotNull() {
            addCriterionEx("tag_logic_name4 is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4EqualTo(String valueEx) {
            addCriterionEx("tag_logic_name4 =", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4NotEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name4 <>", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4GreaterThan(String valueEx) {
            addCriterionEx("tag_logic_name4 >", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4GreaterThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name4 >=", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4LessThan(String valueEx) {
            addCriterionEx("tag_logic_name4 <", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4LessThanOrEqualTo(String valueEx) {
            addCriterionEx("tag_logic_name4 <=", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4Like(String valueEx) {
            addCriterionEx("tag_logic_name4 like", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4NotLike(String valueEx) {
            addCriterionEx("tag_logic_name4 not like", valueEx, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4In(List<String> valueExs) {
            addCriterionEx("tag_logic_name4 in", valueExs, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4NotIn(List<String> valueExs) {
            addCriterionEx("tag_logic_name4 not in", valueExs, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4Between(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name4 between", valueEx1, valueEx2, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andNote4NotBetween(String valueEx1, String valueEx2) {
            addCriterionEx("tag_logic_name4 not between", valueEx1, valueEx2, "tagLogicName4");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagIsNull() {
            addCriterionEx("current_data_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagIsNotNull() {
            addCriterionEx("current_data_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagEqualTo(Integer valueEx) {
            addCriterionEx("current_data_flag =", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("current_data_flag <>", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagGreaterThan(Integer valueEx) {
            addCriterionEx("current_data_flag >", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("current_data_flag >=", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagLessThan(Integer valueEx) {
            addCriterionEx("current_data_flag <", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("current_data_flag <=", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagLike(Integer valueEx) {
            addCriterionEx("current_data_flag like", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagNotLike(Integer valueEx) {
            addCriterionEx("current_data_flag not like", valueEx, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagIn(List<Integer> valueExs) {
            addCriterionEx("current_data_flag in", valueExs, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("current_data_flag not in", valueExs, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("current_data_flag between", valueEx1, valueEx2, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCurrentDataFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("current_data_flag not between", valueEx1, valueEx2, "currentDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagIsNull() {
            addCriterionEx("hourly_data_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagIsNotNull() {
            addCriterionEx("hourly_data_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagEqualTo(Integer valueEx) {
            addCriterionEx("hourly_data_flag =", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("hourly_data_flag <>", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagGreaterThan(Integer valueEx) {
            addCriterionEx("hourly_data_flag >", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("hourly_data_flag >=", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagLessThan(Integer valueEx) {
            addCriterionEx("hourly_data_flag <", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("hourly_data_flag <=", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagLike(Integer valueEx) {
            addCriterionEx("hourly_data_flag like", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagNotLike(Integer valueEx) {
            addCriterionEx("hourly_data_flag not like", valueEx, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagIn(List<Integer> valueExs) {
            addCriterionEx("hourly_data_flag in", valueExs, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("hourly_data_flag not in", valueExs, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("hourly_data_flag between", valueEx1, valueEx2, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andHourlyDataFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("hourly_data_flag not between", valueEx1, valueEx2, "hourlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagIsNull() {
            addCriterionEx("daily_data_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagIsNotNull() {
            addCriterionEx("daily_data_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagEqualTo(Integer valueEx) {
            addCriterionEx("daily_data_flag =", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("daily_data_flag <>", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagGreaterThan(Integer valueEx) {
            addCriterionEx("daily_data_flag >", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("daily_data_flag >=", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagLessThan(Integer valueEx) {
            addCriterionEx("daily_data_flag <", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("daily_data_flag <=", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagLike(Integer valueEx) {
            addCriterionEx("daily_data_flag like", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagNotLike(Integer valueEx) {
            addCriterionEx("daily_data_flag not like", valueEx, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagIn(List<Integer> valueExs) {
            addCriterionEx("daily_data_flag in", valueExs, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("daily_data_flag not in", valueExs, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("daily_data_flag between", valueEx1, valueEx2, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andDailyDataFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("daily_data_flag not between", valueEx1, valueEx2, "dailyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagIsNull() {
            addCriterionEx("monthly_data_flag is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagIsNotNull() {
            addCriterionEx("monthly_data_flag is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagEqualTo(Integer valueEx) {
            addCriterionEx("monthly_data_flag =", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagNotEqualTo(Integer valueEx) {
            addCriterionEx("monthly_data_flag <>", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagGreaterThan(Integer valueEx) {
            addCriterionEx("monthly_data_flag >", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("monthly_data_flag >=", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagLessThan(Integer valueEx) {
            addCriterionEx("monthly_data_flag <", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("monthly_data_flag <=", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagLike(Integer valueEx) {
            addCriterionEx("monthly_data_flag like", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagNotLike(Integer valueEx) {
            addCriterionEx("monthly_data_flag not like", valueEx, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagIn(List<Integer> valueExs) {
            addCriterionEx("monthly_data_flag in", valueExs, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagNotIn(List<Integer> valueExs) {
            addCriterionEx("monthly_data_flag not in", valueExs, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("monthly_data_flag between", valueEx1, valueEx2, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andMonthlyDataFlagNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("monthly_data_flag not between", valueEx1, valueEx2, "monthlyDataFlag");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindIsNull() {
            addCriterionEx("close_kind is null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindIsNotNull() {
            addCriterionEx("close_kind is not null");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindEqualTo(Integer valueEx) {
            addCriterionEx("close_kind =", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindNotEqualTo(Integer valueEx) {
            addCriterionEx("close_kind <>", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindGreaterThan(Integer valueEx) {
            addCriterionEx("close_kind >", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindGreaterThanOrEqualTo(Integer valueEx) {
            addCriterionEx("close_kind >=", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindLessThan(Integer valueEx) {
            addCriterionEx("close_kind <", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindLessThanOrEqualTo(Integer valueEx) {
            addCriterionEx("close_kind <=", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindLike(Integer valueEx) {
            addCriterionEx("close_kind like", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindNotLike(Integer valueEx) {
            addCriterionEx("close_kind not like", valueEx, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindIn(List<Integer> valueExs) {
            addCriterionEx("close_kind in", valueExs, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindNotIn(List<Integer> valueExs) {
            addCriterionEx("close_kind not in", valueExs, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("close_kind between", valueEx1, valueEx2, "closeKind");
            return (CriteriaEx) this;
        }

        public CriteriaEx andCloseKindNotBetween(Integer valueEx1, Integer valueEx2) {
            addCriterionEx("close_kind not between", valueEx1, valueEx2, "closeKind");
            return (CriteriaEx) this;
        }
    }

    public static class CriteriaEx extends GeneratedCriteriaTagM {

        protected CriteriaEx() {
            super();
        }
    }

    public static class CriterionEx {
        private String conditionEx;

        private Object valueEx;

        private Object secondValueEx;

        private boolean noValueEx;

        private boolean singleValueEx;

        private boolean betweenValueEx;

        private boolean listValueEx;

        private String typeHandlerEx;

        public String getCondition() {
            return conditionEx;
        }

        public Object getValue() {
            return valueEx;
        }

        public Object getSecondValue() {
            return secondValueEx;
        }

        public boolean isNoValue() {
            return noValueEx;
        }

        public boolean isSingleValue() {
            return singleValueEx;
        }

        public boolean isBetweenValue() {
            return betweenValueEx;
        }

        public boolean isListValue() {
            return listValueEx;
        }

        public String getTypeHandler() {
            return typeHandlerEx;
        }

        protected CriterionEx(String conditionEx) {
            super();
            this.conditionEx = conditionEx;
            this.typeHandlerEx = null;
            this.noValueEx = true;
        }

        protected CriterionEx(String conditionEx, Object valueEx, String typeHandlerEx) {
            super();
            this.conditionEx = conditionEx;
            this.valueEx = valueEx;
            this.typeHandlerEx = typeHandlerEx;
            if (valueEx instanceof List<?>) {
                this.listValueEx = true;
            } else {
                this.singleValueEx = true;
            }
        }

        protected CriterionEx(String conditionEx, Object valueEx) {
            this(conditionEx, valueEx, null);
        }

        protected CriterionEx(String conditionEx, Object valueEx, Object secondValueEx, String typeHandlerEx) {
            super();
            this.conditionEx = conditionEx;
            this.valueEx = valueEx;
            this.secondValueEx = secondValueEx;
            this.typeHandlerEx = typeHandlerEx;
            this.betweenValueEx = true;
        }

        protected CriterionEx(String conditionEx, Object valueEx, Object secondValueEx) {
            this(conditionEx, valueEx, secondValueEx, null);
        }
    }
}