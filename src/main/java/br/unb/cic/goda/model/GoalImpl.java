package br.unb.cic.goda.model;

import br.unb.cic.pistar.model.PistarNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GoalImpl implements Goal, Serializable {
	private static final long serialVersionUID = 1L;

    private String mode;
    private String attribute;
    private String creationProperty;
    private String invariantProperty;
    private String fulfillmentProperty;
    private boolean isRootGoal = true;
    private List<Goal> decompositionList = new ArrayList<>();
    private List<Plan> meansToAnEndPlans = new ArrayList<>();
    private String name;
    private boolean selected;
    private boolean isAndDecomposition = false;
    private boolean isOrDecomposition = false;
    private boolean isAndParalelDecomposition = false;
    private boolean isOrParalelDecomposition = false;
    private boolean isTryDecomposition = false;
    private boolean isRetryDecomposition = false;

    public GoalImpl(PistarNode pistarGoal) {
        super();
        this.name = pistarGoal.getText();
        if (pistarGoal.getCustomProperties() != null) {
            pistarGoal.getCustomProperties().forEach((key, value) -> {
                switch (key) {
                    case "attribute":
                        attribute = value;
                        break;
                    case "creationProperty":
                        creationProperty = value;
                        break;
                    case "fulfillmentProperty":
                        fulfillmentProperty = value;
                        break;
                    case "invariantProperty":
                        invariantProperty = value;
                        break;
                    case "mode":
                        mode = value;
                        break;
                    case "selected":
                        if (value != null && value.equals("true")) {
                            selected = true;
                        }
                }
            });
        }
    }

    @Override
    public String getMode() {
        return mode;
    }

    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String getAttribute() {
        return attribute;
    }

    @Override
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getCreationProperty() {
        return creationProperty;
    }

    @Override
    public void setCreationProperty(String creationProperty) {
        this.creationProperty = creationProperty;
    }

    @Override
    public String getInvariantProperty() {
        return invariantProperty;
    }

    @Override
    public void setInvariantProperty(String invariantProperty) {
        this.invariantProperty = invariantProperty;
    }

    @Override
    public String getFulfillmentProperty() {
        return fulfillmentProperty;
    }

    @Override
    public void setFulfillmentProperty(String fulfillmentProperty) {
        this.fulfillmentProperty = fulfillmentProperty;
    }

    @Override
    public void addToDecompositionList(Goal goal) {
        decompositionList.add(goal);
    }

    @Override
    public List<Plan> getMeansToAnEndPlans() {
        return meansToAnEndPlans;
    }

    @Override
    public void addToMeansToAnEndPlans(Plan meansToAnEndPlan) {
        meansToAnEndPlans.add(meansToAnEndPlan);
    }

    @Override
    public List<Goal> getDecompositionList() {
        return decompositionList;
    }

    @Override
    public boolean isRootGoal() {
        return isRootGoal;
    }

    @Override
    public void setRootGoal(boolean rootGoal) {
        isRootGoal = rootGoal;
    }

    @Override
    public String getNamePrefix() {
        return "HardGoal ";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

	@Override
	public boolean isAndDecomposition() {
		return this.isAndDecomposition;
	}

	@Override
	public boolean isOrDecomposition() {
		return this.isOrDecomposition;
	}

	@Override
	public boolean isAndParalelDecomposition() {
		return this.isAndParalelDecomposition;
	}

	@Override
	public boolean isOrParalelDecomposition() {
		return this.isOrParalelDecomposition;
	}

	@Override
	public boolean isTryDecomposition() {
		return this.isTryDecomposition;
	}

	@Override
	public boolean isRetryDecomposition() {
		return this.isRetryDecomposition;
	}

	@Override
	public void setAndDecomposition(boolean andDecomposition) {
		this.isAndDecomposition = andDecomposition;
	}

	@Override
	public void setOrDecomposition(boolean orDecomposition) {
		this.isOrDecomposition = orDecomposition;
	}

	@Override
	public void setAndParalelDecomposition(boolean andPDecomposition) {
		this.isAndParalelDecomposition = andPDecomposition;
	}

	@Override
	public void setOrParalelDecomposition(boolean orPDecomposition) {
		this.isOrParalelDecomposition = orPDecomposition;
	}

	@Override
	public void setTryDecomposition(boolean tryDecomposition) {
		this.isTryDecomposition = tryDecomposition;
	}

	@Override
	public void setRetryDecomposition(boolean retryDecomposition) {
		this.isRetryDecomposition = retryDecomposition;
	}
}