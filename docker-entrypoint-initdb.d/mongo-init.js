db.createUser(
    {
        user: "thesisDBTest",
        pwd: "1gmUFFHFLYjaeNTpqHsUZmjNR9J8Lm",
        roles: [
            {
                role: "readWrite",
                db: "thesisDB"
            }
        ]
    }
);