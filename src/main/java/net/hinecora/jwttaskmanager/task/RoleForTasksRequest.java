package net.hinecora.jwttaskmanager.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hinecora.jwttaskmanager.user.RoleForTasks;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleForTasksRequest {
    private RoleForTasks role;
}
