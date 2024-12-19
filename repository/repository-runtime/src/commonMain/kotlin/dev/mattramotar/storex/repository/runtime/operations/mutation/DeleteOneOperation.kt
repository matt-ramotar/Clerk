package dev.mattramotar.storex.repository.runtime.operations.mutation

import dev.mattramotar.storex.repository.runtime.DataSources
import dev.mattramotar.storex.repository.runtime.Result

interface DeleteOneOperation<Key, Error> {
    suspend fun deleteOne(key: Key, dataSources: DataSources? = null): Result<Int, Error>
}