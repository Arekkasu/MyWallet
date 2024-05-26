dime que hace este trigger:



CREATE OR REPLACE FUNCTION update_total_amount_on_revenue_change() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
UPDATE users SET total_amount = total_amount - OLD.revenue_amount WHERE id_users = OLD.users_id_users;
ELSIF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
UPDATE users SET total_amount = total_amount + NEW.revenue_amount WHERE id_users = NEW.users_id_users;
END IF;
RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER revenue_change_trigger
    AFTER INSERT OR UPDATE OR DELETE ON revenue
    FOR EACH ROW EXECUTE PROCEDURE update_total_amount_on_revenue_change();

CREATE OR REPLACE FUNCTION update_total_amount_on_expense_change() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
UPDATE users SET total_amount = total_amount + OLD.expense_amount WHERE id_users = OLD.users_id_users;
ELSIF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
UPDATE users SET total_amount = total_amount - OLD.expense_amount WHERE id_users = OLD.users_id_users;
END IF;
RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER expense_change
    AFTER INSERT OR UPDATE OR DELETE ON expenses
    FOR EACH ROW EXECUTE PROCEDURE update_total_amount_on_expense_change();