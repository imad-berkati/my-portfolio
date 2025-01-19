ALTER TABLE myportfolio.projects_skills
ADD CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES myportfolio.projects (id) ON DELETE CASCADE;

ALTER TABLE myportfolio.projects_skills
ADD CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES myportfolio.skills (id) ON DELETE CASCADE;
